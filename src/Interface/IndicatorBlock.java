package Interface;

public class IndicatorBlock {

    private int index;
    private boolean status;
    private int posX;
    private int posY;

    private boolean statusLoading;
    private boolean statusDone;

    public IndicatorBlock(int index, boolean status, int posX, int posY) {
        this.index = index;
        this.status = status;
        this.posX = posX;
        this.posY = posY;
    }

    public int getIndex() {
        return index;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isStatusLoading() {
        return statusLoading;
    }

    public void setStatusLoading(boolean statusLoading) {
        this.statusLoading = statusLoading;
    }

    public boolean isStatusDone() {
        return statusDone;
    }

    public void setStatusDone(boolean statusDone) {
        this.statusDone = statusDone;
    }
}
