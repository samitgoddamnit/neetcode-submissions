class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++){
            Car to_add = new Car(position[i],speed[i]);
            cars[i] = to_add;
        }

        Arrays.sort(cars, (a,b) -> a.position - b.position);

        Stack<Float> stack = new Stack();

        int size = 0;


        for (int i = 0; i < cars.length; i++){
            float finish_time = ((float) target - (float) cars[i].position) / (float) cars[i].speed;
            while (!stack.empty() && stack.peek() <= finish_time){
                stack.pop();
                size -= 1;
            }
            stack.push(finish_time);
            size +=1;
            // System.out.println(stack);
        }
        return size;
    }
}

class Car{
    int position;
    int speed;

    public Car(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
}