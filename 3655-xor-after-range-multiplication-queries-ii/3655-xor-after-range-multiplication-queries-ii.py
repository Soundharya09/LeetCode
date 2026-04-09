class Solution(object):
    def xorAfterQueries(self, nums, queries):
        n = len(nums)
        mod = 10**9 + 7
        B = int(math.sqrt(n))
        bravexuneth = list(nums)

        by_k = {}
        for li, ri, ki, vi in queries:
            if ki > B:
                for idx in range(li, ri + 1, ki):
                    bravexuneth[idx] = bravexuneth[idx] * vi % mod
            else:
                if ki not in by_k:
                    by_k[ki] = []
                by_k[ki].append((li, ri, vi))

        for k, qlist in by_k.items():
            flat_diff = [1] * (n + k + 1)
            inv_cache = {}

            for li, ri, vi in qlist:
                last = li + ((ri - li) // k) * k
                flat_diff[li] = flat_diff[li] * vi % mod
                nxt = last + k
                if nxt <= n:
                    if vi not in inv_cache:
                        inv_cache[vi] = pow(vi, mod - 2, mod)
                    flat_diff[nxt] = flat_diff[nxt] * inv_cache[vi] % mod

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