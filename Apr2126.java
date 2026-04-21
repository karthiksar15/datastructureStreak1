public class Apr2126 {

    public static void main(String[] args) {
        Apr2026 apr = new Apr2026();
        List<Integer> nums = Arrays.asList(2, 1, 1);
        List<List<Integer>> result = new ArrayList<>();
        nums.sort((a, b) -> Integer.compare(a, b));
        // Collections.sort(nums);
        apr.permute(result, new ArrayList<>(), nums, new boolean[nums.size()]);
        System.out.println("permute--->" + result);
    }

    public void permute(List<List<Integer>> output, List<Integer> nums, List<Integer> input, boolean[] visited) {
        if (input.size() == nums.size()) {
            output.add(new ArrayList<>(nums));
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            if (visited[i] || (i > 0 && input.get(i) == input.get(i - 1) && (!visited[i - 1])))
                continue;
            visited[i] = true;
            nums.add(input.get(i));
            permute(output, nums, input, visited);
            visited[i] = false;
            nums.remove(nums.size() - 1);
        }
    }

}
