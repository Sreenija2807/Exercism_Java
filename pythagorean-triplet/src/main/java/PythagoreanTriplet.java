import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PythagoreanTriplet {

    private final int a;
    private final int b;
    private final int c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }

    static class TripletListBuilder {
        private final List<PythagoreanTriplet> triplets = new ArrayList<>();
        private int max = Integer.MAX_VALUE;
        private int sum = 0;

        TripletListBuilder thatSumTo(int sum) {
            this.sum= sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            max = maxFactor;
            return this;
        }

        List<PythagoreanTriplet> build() {
            max = Math.min(max,sum/2);
            for (int c = 3; c <= max; c++) {
                if(c >sum)
                    break;
                int cSquare = c * c;
                for (int b = 2;b<c;b++){
                    if((b+c)>sum)
                        break;
                    int bSquare = b * b;
                    int a = sum - b - c;
                    int aSquare = a * a;
                    if(a < b && (aSquare + bSquare) == cSquare) {
                        triplets.add(0, new PythagoreanTriplet(a, b, c));
                    }
                }
            }
            return triplets;
        }

    }
    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", a, b, c);
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof PythagoreanTriplet other)
            return a == other.a && b == other.b && c == other.c;
        return false;
    }
}