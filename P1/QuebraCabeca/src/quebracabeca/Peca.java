
package quebracabeca;

public class Peca {
    Borda bordaUp;
    Borda bordaDown;
    Borda bordaLeft;
    Borda bordaRight;

    public Peca(Borda bordaUp, Borda bordaDown, Borda bordaLeft, Borda bordaRight) {
        this.bordaUp = bordaUp;
        this.bordaDown = bordaDown;
        this.bordaLeft = bordaLeft;
        this.bordaRight = bordaRight;
    }

    public Borda getBordaUp() {
        return bordaUp;
    }

    public Borda getBordaDown() {
        return bordaDown;
    }

    public Borda getBordaLeft() {
        return bordaLeft;
    }

    public Borda getBordaRight() {
        return bordaRight;
    }

    public void setBordaUp(Borda bordaUp) {
        this.bordaUp = bordaUp;
    }

    public void setBordaDown(Borda bordaDown) {
        this.bordaDown = bordaDown;
    }

    public void setBordaLeft(Borda bordaLeft) {
        this.bordaLeft = bordaLeft;
    }

    public void setBordaRight(Borda bordaRight) {
        this.bordaRight = bordaRight;
    }

}
