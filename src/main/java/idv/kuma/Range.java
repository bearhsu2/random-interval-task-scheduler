package idv.kuma;

class Range {
    private final int startInclusive;
    private final int endExclusive;


    Range(int startInclusive, int firstEnd) {
        this.startInclusive = startInclusive;
        this.endExclusive = firstEnd;
    }


    public int getStartInclusive() {
        return startInclusive;
    }


    public int getEndExclusive() {
        return endExclusive;
    }
}
