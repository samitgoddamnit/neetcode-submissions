class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        stack = []
        for i in range(len(temperatures)):
            # print(i)
            if not bool(stack):
                stack.append([i,temperatures[i]])
            else:
                while(bool(stack) and stack[len(stack) - 1][1] < temperatures[i]):
                    tmp = stack.pop();
                    # print("popped something")
                    result[tmp[0]] = i - tmp[0]
                stack.append([i,temperatures[i]])
        return result