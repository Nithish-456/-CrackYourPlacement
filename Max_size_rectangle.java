class Main {
static int maxHist(int R, int C, int row[])
    {
Stack<Integer> result = new Stack<Integer>();

        int top_val; // Top of stack

        int max_area = 0; // Initialize max area in current
        // row (or histogram)

        int area = 0; // Initialize area with current top

        // Run through all bars of given histogram (or row)
        int i = 0;
        while (i < C) {
            // If this bar is higher than the bar on top
            // stack, push it to stack
            if (result.empty()
                || row[result.peek()] <= row[i])
                result.push(i++);

            else {
                // If this bar is lower than top of stack,
                // then calculate area of rectangle with
                // stack top as the smallest (or minimum
                // height) bar. 'i' is 'right index' for the
                // top and element before top in stack is
                // 'left index'
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;
                if (!result.empty())
                    area
                        = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }

while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
