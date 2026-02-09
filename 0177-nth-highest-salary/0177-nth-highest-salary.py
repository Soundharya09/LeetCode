import pandas as pd
def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    colName = 'getNthHighestSalary('+str(N)+')'
    df = employee.drop_duplicates(['salary'])
    
    if 0 < N <= df.salary.count():
        df = df.sort_values('salary')
        salary = [df.iloc[-N, 1]]  
    else:
        salary = [None]     
        
    return pd.DataFrame({colName: salary})  
