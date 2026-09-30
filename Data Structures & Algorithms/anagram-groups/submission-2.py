class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
            final_map = {}
            for string in strs:
                frequency = {}
                for i in range(len(string)):
                    frequency[string[i]] = 1 + frequency.get(string[i],0)

                
                key = tuple(sorted(frequency.items()))

                if key not in final_map:
                    final_map[key] = []

                final_map[key].append(string)
            
            result = []
            for k,v in final_map.items():
                result.append(v)
            return result
                