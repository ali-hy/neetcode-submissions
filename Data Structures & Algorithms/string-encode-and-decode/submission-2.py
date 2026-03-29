class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += '{}:{}'.format(len(s), s)
        return res

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        while i < len(s):
            start = i
            while s[i] != ':':
                i += 1
            l = int(s[start:i])
            i += 1
            if (l == 0):
                res.append('')
                continue
            res.append(s[i:i+l])
            i = i + l
        return res