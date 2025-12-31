public class Mar8 {

    public static void main(String[] args) {
        Mar8 mar = new Mar8();

    }

    private static int manhattan(int r, int c, int tr, int tc) {
        return Math.abs(tr - r) + Math.abs(tc - c);
    }

    static class State implements Comparable<State> {
        int r, c, tr, tc, steps, k, f;

        public State(int tr, int tc, int r, int c, int k, int steps) {
            this.tr = tr;
            this.tc = tc;
            this.r = r;
            this.c = c;
            this.k = k;
            this.steps = steps;
            this.f = steps + manhattan(r, c, tr, tc);
        }

        @Override
        public int compareTo(State o) {

            if (this.f != o.f) {
                return this.f - o.f;
            }
            return this.steps - o.steps;

        }
    }

}
