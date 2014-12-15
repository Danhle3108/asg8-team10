
package jWhiteBoard;

import org.jgroups.util.Streamable;

import java.io.DataInput;
import java.io.DataOutput;

/**
 * Encapsulates information about a draw command.
 * Used by the {@link JWhiteBoard} and other demos.
 *
 */
public class DrawCommand implements Streamable {
    static final byte DRAW=1;
    static final byte CLEAR=2;
    byte mode;
    int x;
    int y;
    int rgb;
    //khai bao bien iBrush o day
    int iBrushsize;

    public DrawCommand() { // needed for streamable
    }

    DrawCommand(byte mode) {
        this.mode=mode;
    }
// them tham so iBrushSize
    DrawCommand(byte mode, int x, int y, int rgb,int iBrushsize) {
        this.mode=mode;
        this.x=x;
        this.y=y;
        this.rgb=rgb;
        this.iBrushsize=iBrushsize;
    }


    // de lay gia tri ibrush kia ve xai` cho Suong
    public void writeTo(DataOutput out) throws Exception {
        out.writeByte(mode);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(rgb);
        out.writeInt(iBrushsize);
        
    }
// doc cai gia tri do de xai` cho sung suong' cuoc doi`
    public void readFrom(DataInput in) throws Exception {
        mode=in.readByte();
        x=in.readInt();
        y=in.readInt();
        rgb=in.readInt();
        iBrushsize=in.readInt();
    }


    public String toString() {
        StringBuilder ret=new StringBuilder();
        switch(mode) {
            case DRAW: ret.append("DRAW(" + x + ", " + y + ") [" + rgb + "] ["+iBrushsize+"]");
                break;
            case CLEAR: ret.append("CLEAR");
                break;
            default:
                return "<undefined>";
        }
        return ret.toString();
    }

}
