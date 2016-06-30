package com.infragistics.samplesbrowser;

import com.infragistics.samples.barcode.*;
import com.infragistics.samples.bulletgraph.*;
import com.infragistics.samples.grid.*;
import com.infragistics.samples.chart.*;
import com.infragistics.samples.lineargauge.*;
import com.infragistics.samples.radialgauge.*;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Handler _drawerHandler = new Handler();
    private DrawerLayout _drawerLayout;
    private ListView _leftDrawer;

    private FrameLayout _contentFrame;

    private ActionBarDrawerToggle _leftDrawerToggle;
    private CharSequence _drawerTitle;
    private CharSequence _currentTitle;

    private int paddingMedium = 5;
    private int paddingSmall = 5;
    private SampleManager sampleManager;

    public int getContentWidth() {
        return _contentFrame.getWidth() - _contentFrame.getPaddingLeft() - _contentFrame.getPaddingRight();
    }

    public int getContentHeight() {
        return  _contentFrame.getHeight() - _contentFrame.getPaddingTop() - _contentFrame.getPaddingBottom();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _contentFrame = (FrameLayout)findViewById(R.id.content_frame);

        sampleManager = new SampleManager();

        paddingMedium = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                5, getResources().getDisplayMetrics());

        paddingSmall = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                2, getResources().getDisplayMetrics());

        setTitle("Area Series");
        _currentTitle = getTitle();
        _drawerTitle = getTitle();
        _drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        _leftDrawer = (ListView)findViewById(R.id.left_drawer);
        _leftDrawer.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, sampleManager.samplesNames) {

            @Override
            public View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
                View superView = super.getView(position, convertView, parent);
                String sampleName = sampleManager.samplesNames.get(position);
                TextView tv = (TextView)superView;
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                tv.setPadding(4, 4, 4, 4);

                if (isSampleParent(sampleName))  {

                    tv.setClickable(true);
                    tv.setTextColor(Color.parseColor("#27a1b4"));

                }
                else {

                    tv.setTextColor(Color.parseColor("#f0f8ff"));
                    tv.setClickable(false);
                    tv.setPadding(20, 5,5,5);
                }

                return superView;
            }

            private boolean isSampleParent(String sampleName) {
                SampleInfo info = sampleManager.samplesMap.get(sampleName);

                return info.isSampleGroup;
            }

        });
        _leftDrawer.setOnItemClickListener(new ItemClickListener());
        _leftDrawerToggle = new ActionBarDrawerToggle(this, _drawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(_currentTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(_currentTitle);
                invalidateOptionsMenu();
            }
        };
        _drawerLayout.setDrawerListener(_leftDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        CreateSampleView("Welcome Page");

    }

    private int _currentSamplesPosition = 0;
    SampleLayout currentSample;

    private void CreateSampleView(String sampleName) {

        updateTitle(sampleName);

        if (currentSample != null)
            currentSample.cleanup();

        SampleInfo info = sampleManager.samplesMap.get(sampleName);
        if (info.isSampleGroup) return;

        switch (info.majorType) {
            case WELCOME_PAGE:
                setActiveSample(new LandingPage(this));
                break;
            case CATEGORY_HORIZONTAL_SERIES:
                setActiveSample(new ChartCategoryHorizontalSeriesSample(this, info, true, false));
                //CreateHorizontalCategorySample(info, false);
                break;
            case CATEGORY_HORIZONTAL_SERIES_SMALLDATA:
                setActiveSample(new ChartCategoryHorizontalSeriesSample(this, info, false, true));
                //CreateHorizontalCategorySample(info, true);
                break;
            case CATEGORY_BAR:
                setActiveSample(new ChartCategoryBarSeriesSample(this, info, true, true));
                //CreateBarCategorySample(info, true);
                break;
            case CATEGORY_RANGE:
                setActiveSample(new ChartCategoryRangeSeriesSample(this, info, false, false));
                //CreateRangeCategorySample(info, false);
                break;
            case CATEGORY_RANGE_SMALLDATA:
                setActiveSample(new ChartCategoryRangeSeriesSample(this, info, false, true));
                //CreateRangeCategorySample(info, true);
                break;
            case CATEGORY_MARKERS:
                setActiveSample(new ChartCategoryMarkersSample(this, info, false, true));
                //CreateRangeCategorySample(info, true);
                break;
            //case CATEGORY_SIZECHANGE:
            //    setActiveSample(new ChartSizeChangingSample(this, info, false, true));
            //    //CreateRangeCategorySample(info, true);
            //    break;
            case TRENDLINES:
                setActiveSample(new ChartCategoryTrendlinesSample(this, info, false, true));
                //CreateTrendlinesSample(info, false);
                break;
            case FINANCIAL_PRICE:
                boolean useCandlestick = false;
                if (sampleName.contains("Candlestick")) {
                    useCandlestick = true;
                }
                setActiveSample(new ChartFinancialSeriesSample(this, info, false, useCandlestick));
                //CreateFinancialSample(info, isCandlestick);
                break;
            case FINANCIAL_INDICATOR:
                setActiveSample(new ChartFinancialIndicatorSample(this, info, false));
                //CreateFinancialIndicatorSample(info, true);
                break;
            case FINANCIAL_LIVE:
                setActiveSample(new ChartFinancialLiveSample(this, info, false, true));
                //CreateFinancialLiveSample(info, true);
                break;

            case SCATTER_POINT:
                setActiveSample(new ChartScatterPointSeriesSample(this, info, false));
                //CreateScatterSample(info);
                break;
            case SCATTER_BUBBLE:
                setActiveSample(new ChartScatterBubbleSeriesSample(this, info, false, false));
                //CreateScatterBubbleSample(info);
                break;
            case SCATTER_BUBBLE_LEGEND:
                setActiveSample(new ChartScatterBubbleSeriesSample(this, info, true, true));
                //CreateScatterBubbleSample(info);
                break;
            case SCATTER_CONTINUES:
                setActiveSample(new ChartScatterContinuesSeriesSample(this, info, true));
                //CreateScatterContinuesSample(info);
                break;
            case POLAR_SERIES:
                setActiveSample(new ChartPolarSeriesSample(this, info, true));
                //CreatePolarSample(info);
                break;
            case RADIAL_SERIES:
                setActiveSample(new ChartRadialSeriesSample(this, info, true));
                //CreateRadialSample(info, false);
                break;
            case STACKED:
                setActiveSample(new StackedSeriesSample(this, info, true, true));
                break;
//		case RADIAL_SMALLDATA:
//			//CreateRadialSample(info, true);
//			setActiveSample(new ChartRadialSeriesSample(this, info));
//			break;

            case PIE_EXPLOSION:
                setActiveSample(new PieChartAnimationSample(this));
                break;
            case PIE_OPTIONS:
                setActiveSample(new PieChartOptionsSample(this));
                break;
            case PIE_LEGEND:
                setActiveSample(new PieChartLegendSample(this));
                break;
            case PIE_GRADIENT:
                setActiveSample(new PieChartRadialGradientSample(this));
                break;

            case FUNNEL_OPTIONS:
                setActiveSample(new FunnelChartOptionsSample(this));
                break;

            case FUNNEL_BEZIER:
                setActiveSample(new FunnelChartBezierSample(this));
                break;

            case RADIAL_GAUGE_ANIMATION:
                setActiveSample(new RadialGaugeAnimationSample(this));
                break;
            case RADIAL_GAUGE_LABELS:
                setActiveSample(new RadialGaugeLabelsSample(this));
                break;
            case RADIAL_GAUGE_NEEDLE:
                setActiveSample(new RadialGaugeNeedleSample(this));
                break;
            case RADIAL_GAUGE_RANGE:
                setActiveSample(new RadialGaugeRangeSample(this));
                break;
            case RADIAL_GAUGE_COMPASS:
                setActiveSample(new RadialGaugeCompass(this));
                break;
            case RADIAL_GAUGE_CLOCK:
                setActiveSample(new RadialGaugeClock(this));
                break;

            case LINEAR_GAUGE_ANIMATION:
                setActiveSample(new LinearGaugeAnimationSample(this));
                break;
            case LINEAR_GAUGE_LABELS:
                setActiveSample(new LinearGaugeLabelsSample(this));
                break;
            case LINEAR_GAUGE_NEEDLE:
                setActiveSample(new LinearGaugeNeedleSample(this));
                break;

            case BULLET_GRAPH_ANIMATION:
                setActiveSample(new BulletGraphAnimationSample(this));
                break;
            case BULLET_GRAPH_OPTIONS:
                setActiveSample(new BulletGraphOptionsSample(this));
                break;

            case ANNOTATION_LAYERS:
                if (sampleName.contains("Crosshair Layer")) {
                    setActiveSample(new ChartCrosshairLayerSample(this, info, false));
                    //CreateCrosshairLayerSample(info, true);
                    break;
                } else if (sampleName.contains("Category Highlight Layer")) {
                    setActiveSample(new ChartCategoryHighlightLayerSample(this, info, false, true));
                    //CreateCategoryHighlightLayerSample(info, true);
                    break;
                } else if (sampleName.contains("Item Tooltip Layer")) {
                    setActiveSample(new ItemToolTipLayerSample(this, info, false));
                    break;
                } else if (sampleName.contains("Category Tooltip Layer")) {
                    setActiveSample(new CategoryToolTipLayerSample(this, info, false));
                    break;
                }
                //else if (sampleName.contains("Category Tooltip Layer")) {
                //CreateCategoryTooltipLayerSample(info, true);
                //break;
                //}
                //else if (sampleName.contains("Item Tooltip Layer")) {
                //CreateItemTooltipLayerSample(info, true);
                //break;
                //}
                else if (sampleName.contains("Category Item Highlight Layer")) {
                    setActiveSample(new ChartCategoryItemHighlightLayerSample(this, info, false));
                    //CreateCategoryItemHighlightLayerSample(info, true);
                    break;
                }

            case NUMERIC_INTERVALS:
                setActiveSample(new ChartNumericXAxisIntervals(this, info, true, false));
                break;

            case CATEGORY_INTERVALS:
                setActiveSample(new ChartCategoryXAxisIntervals(this, info, true, false));
                break;

            case GRID_SIMPLE:
                setActiveSample(new SimpleListSample(this));
                break;
            case GRID_RESPONSIVE_SIDE_BAR:
                setActiveSample(new ResponsiveGridSideBarSample(this));
                break;
            case GRID_RESPONSIVE_ROTATION:
                setActiveSample(new ResponsiveGridRotationSample(this));
                break;
            case GRID_IMMERSIVE_ACTIVITY_TRACKER:
                setActiveSample(new ImmersiveGridActivityTracker(this));
                break;
            case GRID_ANIMATION_ADD_COLUMN:
                setActiveSample(new GridAddColumnAnimation(this));
                break;
            case GRID_ANIMATION_SHOW_COLUMN:
                setActiveSample(new GridShowColumnAnimation(this));
                break;
            case GRID_ANIMATION_HIDE_COLUMN:
                setActiveSample(new GridHideColumnAnimation(this));
                break;
            case GRID_ANIMATION_MOVE_COLUMN:
                setActiveSample(new GridMoveColumnAnimation(this));
                break;
            case GRID_ANIMATION_XCHG_COLUMN:
                setActiveSample(new GridExchangeColumnAnimation(this));
                break;
            case GRID_ANIMATION_PROP_UPDATE:
                setActiveSample(new GridPropertyUpdateAnimation(this));
                break;
            case GRID_REMOTE_LIST:
             //   setActiveSample(new RemoteListSample(this));
                break;
            case GRID_SELECTION:
                setActiveSample(new GridSelection(this));
                break;
            case GRID_TEXT_COLUMN:
                setActiveSample(new GridTextColumnSample(this));
                break;
            case GRID_DATE_COLUMN:
                setActiveSample(new GridDateTimeColumnSample(this));
                break;
            case GRID_NUMERIC_COLUMN:
                setActiveSample(new GridNumericColumnSample(this));
                break;
            case GRID_IMAGE_COLUMN:
                setActiveSample(new GridImageColumnSample(this));
                break;
            case GRID_TEMPLATE_COLUMN:
                setActiveSample(new GridTemplateColumnSample(this));
                break;
            case BARCODE_128_SAMPLE:
                setActiveSample(new Barcode128Sample(this));
                break;
            case BARCODE_QR_SAMPLE:
                setActiveSample(new QrBarcodeSample(this));
                break;
        }
    }

    private void setActiveSample(SampleLayout sample) {

        currentSample = sample;

        _contentFrame.removeAllViews();
        _contentFrame.setPadding(15, 5, 15, 0);
        _contentFrame.addView(currentSample);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        _leftDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        _leftDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (_leftDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_back:
                previousSample();
                return true;
            case R.id.action_forward:
                nextSample();
                return true;
            case R.id.action_info:
                SampleDescDialog diag = new SampleDescDialog();
                diag.setDescription(currentSample.getDescription());
                diag.show(getFragmentManager(), "");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void jumpToSample(String name) {

        _currentSamplesPosition = sampleManager.samplesNames.indexOf(name);

        SampleInfo info = sampleManager.samplesMap.get(sampleManager.samplesNames.get(_currentSamplesPosition));
        if (info.isSampleGroup) {
            previousSample();
            return;
        }

        _leftDrawer.performItemClick(
                _leftDrawer.getAdapter().getView(_currentSamplesPosition, null, null),
                _currentSamplesPosition,
                _leftDrawer.getAdapter().getItemId(_currentSamplesPosition));

        _leftDrawer.smoothScrollToPosition(_currentSamplesPosition);
        //CreateSampleView(sampleManager.samplesNames.get(_currentSamplesPosition));
    }

    private void previousSample() {
        _currentSamplesPosition--;

        if (_currentSamplesPosition < 0) {
            _currentSamplesPosition = sampleManager.samplesNames.size() - 1;
        }

        SampleInfo info = sampleManager.samplesMap.get(sampleManager.samplesNames.get(_currentSamplesPosition));
        if (info.isSampleGroup) {
            previousSample();
            return;
        }

        _leftDrawer.performItemClick(
                _leftDrawer.getAdapter().getView(_currentSamplesPosition, null, null),
                _currentSamplesPosition,
                _leftDrawer.getAdapter().getItemId(_currentSamplesPosition));

        //CreateSampleView(sampleManager.samplesNames.get(_currentSamplesPosition));
    }

    private void nextSample() {
        _currentSamplesPosition++;

        if (_currentSamplesPosition > sampleManager.samplesNames.size() - 1) {
            _currentSamplesPosition = 0;
        }

        SampleInfo info = sampleManager.samplesMap.get(sampleManager.samplesNames.get(_currentSamplesPosition));
        if (info.isSampleGroup) {
            nextSample();
            return;
        }

        _leftDrawer.performItemClick(
                _leftDrawer.getAdapter().getView(_currentSamplesPosition, null, null),
                _currentSamplesPosition,
                _leftDrawer.getAdapter().getItemId(_currentSamplesPosition));

        //CreateSampleView(sampleManager.samplesNames.get(_currentSamplesPosition));
    }

    private void updateTitle(CharSequence title) {
        _currentTitle = title;
        getActionBar().setTitle(_currentTitle);
    }

    private class ItemClickListener
            implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
            _currentSamplesPosition = position;
            changeSelection(position);

            _drawerHandler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    _drawerLayout.closeDrawer(_leftDrawer);
                }
            }, 20);
        }

        private void changeSelection(int position) {
            CreateSampleView(sampleManager.samplesNames.get(position));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
}
