def min_cost_breaking_chocolate(test_cases):
    results = []
    for case in test_cases:
        m, n = case['dimensions']
        x_costs = sorted(case['x_costs'], reverse=True)
        y_costs = sorted(case['y_costs'], reverse=True)
        
        total_cost = 0
        horizontal_cuts = 1
        vertical_cuts = 1
        
        while x_costs or y_costs:
            if not y_costs or (x_costs and x_costs[0] >= y_costs[0]):
                total_cost += x_costs.pop(0) * horizontal_cuts
                vertical_cuts += 1
            else:
                total_cost += y_costs.pop(0) * vertical_cuts
                horizontal_cuts += 1
        
        results.append(total_cost)
    return results

# Example usage:
test_cases = [
    {
        "dimensions": (6, 4),
        "x_costs": [2, 1, 3, 1, 4],
        "y_costs": [4, 1, 2],
    }
]

print(min_cost_breaking_chocolate(test_cases))  # Output: [42]
