class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        maps = {}
        index_map = {} 
        for i in range(len(nums)):
             maps[nums[i]] = target - nums[i]
             index_map[nums[i]] = i
        
        for i in range(len(nums)):
            required = maps.get(nums[i])
            if index_map.get(required) and index_map.get(required) != i:
                return [i,index_map.get(required)]
