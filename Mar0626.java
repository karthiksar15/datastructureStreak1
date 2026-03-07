public class Mar0626 {

    class HashSet {
        private int[] set;

        public HashSet() {
            set = new int[31252];
        }

        public void add(int num) {
            set[num / 32] |= getMask(num);
        }

        public void remove(int num) {
            if (contains(num))
                set[num / 32] &= ~getMask(num);
        }

        public boolean contains(int num) {
            return (set[num / 32] & getMask(num)) == 1;
        }

        public int getMask(int num) {
            return 1 << num % 32;
        }
    }
}
