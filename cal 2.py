class Solution:
    def calculate(self, s: str) -> int:
        num, curr_sign, st = 0, '+', []
        for ch in s + '+':
            if ch.isdigit():
                num = num*10 + int(ch)
            elif ch in "+-*/":
                if curr_sign == '+':
                    st.append(num)
                elif curr_sign == '-':
                    st.append(-num)
                elif curr_sign == '*':
                    st.append(st.pop() * num)
                elif curr_sign == '/':
                    st.append(math.trunc(st.pop()/ num))
                curr_sign = ch
                num = 0
        return sum(st)
