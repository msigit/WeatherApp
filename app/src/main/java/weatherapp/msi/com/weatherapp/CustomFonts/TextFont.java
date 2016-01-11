package weatherapp.msi.com.weatherapp.CustomFonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MSi on 11/12/2015.
 */
public class TextFont extends TextView {

    public TextFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextFont(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/NotoSerif-Regular.ttf");
        setTypeface(tf);
    }


}
