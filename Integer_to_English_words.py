class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
                "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]

        def threeDigitToWords(n):
            hundred = n // 100
            remainder = n % 100
            result = []
            if hundred > 0:
                result.append(below_20[hundred])
                result.append("Hundred")
            if remainder > 0:
                if remainder < 20:
                    result.append(below_20[remainder])
                else:
                    result.append(tens[remainder // 10])
                    if remainder % 10 > 0:
                        result.append(below_20[remainder % 10])
            return " ".join(result).strip()

        res = []
        for i in range(len(thousands)):
            if num % 1000 != 0:
                res.append(threeDigitToWords(num % 1000) + " " + thousands[i])
            num //= 1000
        return " ".join(res[::-1]).strip()
