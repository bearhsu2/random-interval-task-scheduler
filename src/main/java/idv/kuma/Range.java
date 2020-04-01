package idv.kuma;

class Range {
    private final long startInclusive;
    private final long endExclusive;


    Range(long startInclusive, long firstEnd) {
        this.startInclusive = startInclusive;
        this.endExclusive = firstEnd;
    }


    public long getStartInclusive() {
        return startInclusive;
    }


    public long getEndExclusive() {
        return endExclusive;
    }
}
