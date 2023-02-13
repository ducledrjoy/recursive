package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
class Department {
    private int id;
    private String name;
    private List<Department> childs = new ArrayList<>();
}

public class Main {

    private static int count;

    public static void main(String[] args) {
        Department root = initialDepartment();
        Map<Integer, String> nameSettings = initialNameSettings();

        Department newRoot = changeSettings(nameSettings, root);
        System.out.println(newRoot);
        System.out.println("for loop count : " + count);
    }
    private static Department changeSettings(Map<Integer, String> nameSettings, Department department) {
        List<Department> departments = department.getChilds();
        if (!departments.isEmpty()) {
            for (Department dpt : departments) {
                count ++;
                if (nameSettings.containsKey(dpt.getId())) {
                    dpt.setName(nameSettings.get(dpt.getId()));
                }
                changeSettings(nameSettings, dpt);
            }
        }
        return department;
    }
    public static Department initialDepartment() {
        Department d332 = new Department(332, "D332", new ArrayList<>());
        Department d331 = new Department(331, "D331", new ArrayList<>());

        Department d224 = new Department(224, "D224", new ArrayList<>());
        Department d223 = new Department(223, "D223", new ArrayList<>());
        Department d222 = new Department(222, "D222", new ArrayList<>());
        Department d221 = new Department(221, "D221", new ArrayList<>());

        Department d211 = new Department(211, "D211", new ArrayList<>());

        Department d11 = new Department(11, "D11", new ArrayList<>());
        Department d12 = new Department(12, "D12", new ArrayList<>());

        Department d33 = new Department(33, "D33", Arrays.asList(d331, d332));
        Department d32 = new Department(32, "D32", new ArrayList<>());
        Department d31 = new Department(31, "D31", new ArrayList<>());

        Department d22 = new Department(22, "D22", Arrays.asList(d221, d222, d223, d224));
        Department d21 = new Department(21, "D21", Arrays.asList(d211));

        Department d1 = new Department(1, "D1", Arrays.asList(d11, d12));

        Department d2 = new Department(2, "D2", Arrays.asList(d21, d22));

        Department d3 = new Department(3, "D3", Arrays.asList(d31, d32, d33));

        Department root = new Department(0, "ROOT", Arrays.asList(d1, d2, d3));

        return root;
    }

    public static Map<Integer, String> initialNameSettings() {

        Map<Integer, String> nameSettings = new HashMap<>();
        nameSettings.put(1, "Department 1");
        nameSettings.put(211, "Department 211");
        nameSettings.put(331, "Department 331");
        return nameSettings;
    }
}
