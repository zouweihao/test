package com.infragistics.samples.grid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.infragistics.controls.GridAnimationPhaseSettings;
import com.infragistics.controls.GridEasingFunctionType;

import java.util.ArrayList;

public class PhaseConfigurationView extends LinearLayout {

    private interface GetterSetter<T> {
        T get();
        void set (T t);
    }

    private GridAnimationPhaseSettings _boundSettings;

    public PhaseConfigurationView(Context context, GridAnimationPhaseSettings settings) {
        super(context);
        _boundSettings = settings;

        this.setOrientation(LinearLayout.VERTICAL);

        this.addView(createIntRowView("Desired Sub-Item Duration MS", false, 1000, new GetterSetter<Integer>() {
            @Override
            public Integer get() {
                return _boundSettings.getDesiredSubItemDurationMilliseconds();
            }

            @Override
            public void set(Integer t) {
                _boundSettings.setDesiredSubItemDurationMilliseconds(t);
            }
        }));

        this.addView(createIntRowView("Duration MS", false, 8000, new GetterSetter<Integer>() {
            @Override
            public Integer get() {
                return _boundSettings.getDurationMilliseconds();
            }

            @Override
            public void set(Integer t) {
                _boundSettings.setDurationMilliseconds(t);
            }
        }));

        this.addView(createIntRowView("Hold Initial MS", false, 1000, new GetterSetter<Integer>() {
            @Override
            public Integer get() {
                return _boundSettings.getHoldInitialMilliseconds();
            }

            @Override
            public void set(Integer t) {
                _boundSettings.setHoldInitialMilliseconds(t);
            }
        }));

        this.addView(createIntRowView("Per Item Delay MS", true, 1000, new GetterSetter<Integer>() {
            @Override
            public Integer get() {
                return _boundSettings.getPerItemDelayMilliseconds();
            }

            @Override
            public void set(Integer t) {
                _boundSettings.setPerItemDelayMilliseconds(t);
            }
        }));

        this.addView(createIntRowView("Sub-Item Duration MS", true, 1000, new GetterSetter<Integer>() {
            @Override
            public Integer get() {
                return _boundSettings.getSubItemDurationMilliseconds();
            }

            @Override
            public void set(Integer t) {
                _boundSettings.setSubItemDurationMilliseconds(t);
            }
        }));

        this.addView(createBooleanRowView("Should Items Finish Simultaneously", new GetterSetter<Boolean>() {
            @Override
            public Boolean get() {
                return _boundSettings.getShouldItemsFinishSimultaneously();
            }

            @Override
            public void set(Boolean b) {
                _boundSettings.setShouldItemsFinishSimultaneously(b);
            }
        }));

        this.addView(createEasingFunctionDrop());
    }

    private View createEasingFunctionDrop() {
        LinearLayout mainLayout = new LinearLayout(getContext());
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mainLayout.setOrientation(VERTICAL);

        TextView titleView = new TextView(getContext());
        titleView.setText("Easing Function");

        mainLayout.addView(titleView);

        Spinner spinner = new Spinner(getContext());

        ArrayList<String> list = new ArrayList<String>();
        list.add("Linear");
        list.add("Cubic In Out");
        list.add("Exponential In Out");
        list.add("Circle In Out");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setSelection(_boundSettings.getEasingFunctionType().getValue());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                _boundSettings.setEasingFunctionType(GridEasingFunctionType.valueOf(pos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mainLayout.addView(spinner);

        return mainLayout;
    }

    private View createBooleanRowView(String title, final GetterSetter<Boolean> getterSetter ) {
        LinearLayout mainLayout = new LinearLayout(getContext());
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mainLayout.setOrientation(VERTICAL);

        CheckBox checkBox = new CheckBox(getContext());
        checkBox.setText(title);
        checkBox.setChecked(getterSetter.get());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                getterSetter.set(b);
            }
        });

        mainLayout.addView(checkBox);

        return  mainLayout;
    }

    private View createIntRowView(String title, boolean enableToggle, int maxDuration, final GetterSetter<Integer> getterSetter) {
        LinearLayout mainLayout = new LinearLayout(getContext());
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mainLayout.setOrientation(VERTICAL);

        TextView titleView = new TextView(getContext());
        titleView.setText(title);

        mainLayout.addView(titleView);

        LinearLayout.LayoutParams lp20 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.2f);
        LinearLayout.LayoutParams lp60 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.8f);
        LinearLayout.LayoutParams lp80 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0.8f);

        LinearLayout childLayout = new LinearLayout(getContext());
        childLayout.setOrientation(HORIZONTAL);
        childLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mainLayout.addView(childLayout);

        final TextView valueView = new TextView(getContext());
        valueView.setMinEms(3);
        valueView.setText(((Integer) getterSetter.get()).toString());

        childLayout.addView(valueView);

        final SeekBar seekBar = new SeekBar(getContext());
        seekBar.setMax(maxDuration);
        seekBar.setProgress(getterSetter.get());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valueView.setText(((Integer) i).toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                getterSetter.set(seekBar.getProgress());
            }
        });

        if (enableToggle) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText("Auto");
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        seekBar.setEnabled(false);
                        getterSetter.set(-1);
                        seekBar.setProgress(0);
                        valueView.setText("-1");
                    } else {
                        seekBar.setEnabled(true);
                        getterSetter.set(seekBar.getProgress());
                        valueView.setText(((Integer)seekBar.getProgress()).toString());
                    }
                }
            });

            if (getterSetter.get() == -1) {
                checkBox.setChecked(true);
                seekBar.setEnabled(false);
            }
            childLayout.addView(checkBox, lp20);
            childLayout.addView(seekBar, lp60);
        } else {
            childLayout.addView(seekBar, lp80);
        }

        return mainLayout;
    }
}
