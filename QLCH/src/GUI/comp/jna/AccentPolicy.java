package GUI.comp.jna;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class AccentPolicy extends Structure implements Structure.ByReference {

    public int AccentState;
    public int AccentFlags;
    public int GradientColor;
    public int AnimationId;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(
                "AccentState",
                "AccentFlags",
                "GradientColor",
                "AnimationId");
    }
}