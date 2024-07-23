class Solution:
    def addBinary(self, a: str, b: str) -> str:
        res = []
        carry = 0

        i, j = len(a) -1, len(b) - 1
        while i>=0 or j>=0 or carry:
            sum = carry

            if i >= 0:
                sum += int(a[i])
                i -= 1
            if j >= 0:
                sum += int(b[j])
                j -= 1
            res.append(str(sum % 2)) # Add the current bit to the result
            carry = sum // 2 # calculate carry
        return ''.join(reversed(res))

