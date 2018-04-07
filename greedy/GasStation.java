// https://www.interviewbit.com/problems/gas-station/

import java.util.*;

public class GasStation {
    public static int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int tank = 0;
        int circuit = gas.size();
        int start = 0;
        for (int i = 0; i < circuit; i++) {
            if (tank < 0) {
                if (i > gas.size() * 2) {
                    return -1;
                }
                start = i;
                circuit += start + 1;
                tank = 0;
            }

            tank += (gas.get(i % gas.size()) - cost.get(i % cost.size()));
        }

        return start;
    }

    public static void main(String[] args) {
        // gas: 2, 3, 1, 2
        // cost: 3, 2, 2, 1
        ArrayList<Integer> gas = new ArrayList<>();
        ArrayList<Integer> cost = new ArrayList<>();
        gas.add(2);
        gas.add(3);
        gas.add(1);
        gas.add(2);
        cost.add(3);
        cost.add(2);
        cost.add(2);
        cost.add(1);
        System.out.println("Gas: 2, 3, 1, 2.");
        System.out.println("Cost: 3, 2, 2, 1. ");
        System.out.println("Should yield index 1: " + canCompleteCircuit(gas, cost));
        cost.set(3, 2);
        System.out.println("Cost: 3, 2, 2, 2. ");
        System.out.println("Should yield -1: " + canCompleteCircuit(gas, cost));
    }
}
