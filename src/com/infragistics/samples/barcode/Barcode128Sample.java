package com.infragistics.samples.barcode;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;
import com.infragistics.controls.Code128BarcodeView;
import com.infragistics.controls.Stretch;
import com.infragistics.extensions.Colors;
import com.infragistics.graphics.SolidColorBrush;
import com.infragistics.samplesbrowser.SampleLayout;

public class Barcode128Sample extends SampleLayout {

    public Barcode128Sample(Activity activity) {
        super(activity);
        sampleContainer.setBackgroundColor(Color.WHITE);
        sampleContainer.setPadding(30,30,30,30);

        FrameLayout frame = new FrameLayout(activity);

        final Code128BarcodeView bar128 = new Code128BarcodeView(activity);
        bar128.setBarBrush(new SolidColorBrush(Color.BLACK));
        bar128.setLabelBrush(new SolidColorBrush(Color.BLACK));
        bar128.setStretch(Stretch.FILL);
        bar128.setData("12345678");

        int height =
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        150, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                height);
        params.gravity = Gravity.CENTER;
        frame.setLayoutParams(params);

        frame.addView(bar128);
        setOptions(this.sampleOptions, bar128, activity);
        sampleContainer.addView(frame);
    }

    private void setOptions(LinearLayout sampleLayout, final Code128BarcodeView bar128, final Activity activity)
    {
        final EditText et = new EditText(activity);
        et.setHint("Enter new barcode data");

        Button btnAdd = new Button(activity);
        btnAdd.setText("Set");
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard(activity, view);
                bar128.setData(et.getText().toString());
            }
        });

        LinearLayout option= new LinearLayout(activity);
        option.setOrientation(LinearLayout.HORIZONTAL);
        option.addView(et);
        option.addView(btnAdd);
        sampleLayout.addView(option);
    }

    private static void hideSoftKeyboard (Activity activity, View view)
    {
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    @Override
    protected String getDescription() {
        return "Code 128 Barcode can be used in inventory, shipping and distribution applications.";
    }
}
