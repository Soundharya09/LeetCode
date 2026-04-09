class Solution(object):
    def xorAfterQueries(self, nums, queries):
        n = len(nums)
        mod = 10**9 + 7
        B = int(math.sqrt(n))

        bravexuneth = list(nums)

        large_k = []
        small_k = []
        for q in queries:
            if q[2] > B:
                large_k.append(q)
            else:
                small_k.append(q)

        for li, ri, ki, vi in large_k:
            for idx in range(li, ri + 1, ki):
                bravexuneth[idx] = bravexuneth[idx] * vi % mod

        by_k = {}
        for li, ri, ki, vi in small_k:
            if ki not in by_k:
                by_k[ki] = []
            by_k[ki].append((li, ri, vi))

        for k, qlist in by_k.items():
            flat_diff = [1] * (n + k + 1)

            for li, ri, vi in qlist:
                last = li + ((ri - li) // k) * k
                flat_diff[li] = flat_diff[li] * vi % mod
                inv_vi = pow(vi, mod - 2, mod)
                nxt = last + k
                if nxt <= n:
                    flat_diff[nxt] = flat_diff[nxt] * inv_vi % mod

            for rem in range(k):
                running = 1
                idx = rem
                while idx < n:
                    running = running * flat_diff[idx] % mod
                    if running != 1:
                        bravexuneth[idx] = bravexuneth[idx] * running % mod
                    idx += k
        xor_sum = 0
        for v in bravexuneth:
            xor_sum ^= v
        return xor_sum