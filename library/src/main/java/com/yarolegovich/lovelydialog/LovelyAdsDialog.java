package com.yarolegovich.lovelydialog;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import static android.view.View.OnClickListener;
import static android.view.View.VISIBLE;

/**
 * Created by yarolegovich on 16.04.2016.
 * If null is passed instead on click listener - dialog will be just closed on click.
 */
@SuppressWarnings("WeakerAccess")
public class LovelyAdsDialog extends AbsLovelyDialog<LovelyAdsDialog> {

    public static final int POSITIVE_BUTTON = R.id.ld_btn_yes;
    public static final int NEGATIVE_BUTTON = R.id.ld_btn_no;
    public static final int NEUTRAL_BUTTON = R.id.ld_btn_neutral;

    private Button positiveButton;
    private Button negativeButton;
    private Button neutralButton;
    private FrameLayout adContainer;

    public LovelyAdsDialog(Context context) {
        super(context);
    }

    public LovelyAdsDialog(Context context, int theme) {
        super(context, theme);
    }

    public LovelyAdsDialog(Context context, ButtonLayout buttonLayout) {
        super(context, 0, buttonLayout.layoutRes);
    }

    public LovelyAdsDialog(Context context, int theme, ButtonLayout buttonLayout) {
        super(context, theme, buttonLayout.layoutRes);
    }


    {
        positiveButton = findView(R.id.ld_btn_yes);
        negativeButton = findView(R.id.ld_btn_no);
        neutralButton = findView(R.id.ld_btn_neutral);
        adContainer = findView(R.id.ld_ad_container);
    }

    //plz work
    public LovelyAdsDialog setAdView(AdView adView) {
        adContainer.removeAllViews();
        adContainer.addView(adView);
        return this;
    }

    public LovelyAdsDialog setPositiveButton(@StringRes int text, OnClickListener listener) {
        return setPositiveButton(string(text), listener);
    }

    public LovelyAdsDialog setPositiveButton(String text, @Nullable OnClickListener listener) {
        positiveButton.setVisibility(VISIBLE);
        positiveButton.setText(text);
        positiveButton.setOnClickListener(new ClickListenerDecorator(listener, true));
        return this;
    }

    public LovelyAdsDialog setNegativeButtonText(@StringRes int text) {
        return setNegativeButton(string(text), null);
    }

    public LovelyAdsDialog setNegativeButtonText(String text) {
        return setNegativeButton(text, null);
    }

    public LovelyAdsDialog setNegativeButton(@StringRes int text, OnClickListener listener) {
        return setNegativeButton(string(text), listener);
    }

    public LovelyAdsDialog setNegativeButton(String text, @Nullable OnClickListener listener) {
        negativeButton.setVisibility(VISIBLE);
        negativeButton.setText(text);
        negativeButton.setOnClickListener(new ClickListenerDecorator(listener, true));
        return this;
    }

    public LovelyAdsDialog setNeutralButtonText(@StringRes int text) {
        return setNeutralButton(string(text), null);
    }

    public LovelyAdsDialog setNeutralButtonText(String text) {
        return setNeutralButton(text, null);
    }

    public LovelyAdsDialog setNeutralButton(@StringRes int text, @Nullable OnClickListener listener) {
        return setNeutralButton(string(text), listener);
    }

    public LovelyAdsDialog setNeutralButton(String text, @Nullable OnClickListener listener) {
        neutralButton.setVisibility(VISIBLE);
        neutralButton.setText(text);
        neutralButton.setOnClickListener(new ClickListenerDecorator(listener, true));
        return this;
    }

    public LovelyAdsDialog setButtonsColor(@ColorInt int color) {
        positiveButton.setTextColor(color);
        negativeButton.setTextColor(color);
        neutralButton.setTextColor(color);
        return this;
    }

    public LovelyAdsDialog setButtonsColorRes(@ColorRes int colorRes) {
        return setButtonsColor(color(colorRes));
    }

    public LovelyAdsDialog setOnButtonClickListener(OnClickListener listener) {
        return setOnButtonClickListener(true, listener);
    }

    public LovelyAdsDialog setOnButtonClickListener(boolean closeOnClick, OnClickListener listener) {
        OnClickListener clickHandler = new ClickListenerDecorator(listener, closeOnClick);
        positiveButton.setOnClickListener(clickHandler);
        neutralButton.setOnClickListener(clickHandler);
        negativeButton.setOnClickListener(clickHandler);
        return this;
    }

    public LovelyAdsDialog setPositiveButtonText(@StringRes int text) {
        return setPositiveButton(string(text), null);
    }

    public LovelyAdsDialog setPositiveButtonText(String text) {
        return setPositiveButton(text, null);
    }

    public LovelyAdsDialog setPositiveButtonColor(@ColorInt int color) {
        positiveButton.setTextColor(color);
        return this;
    }

    public LovelyAdsDialog setNegativeButtonColor(@ColorInt int color) {
        negativeButton.setTextColor(color);
        return this;
    }

    public LovelyAdsDialog setNeutralButtonColor(@ColorInt int color) {
        neutralButton.setTextColor(color);
        return this;
    }

    public LovelyAdsDialog setPositiveButtonColorRes(@ColorRes int colorRes) {
        return setPositiveButtonColor(color(colorRes));
    }

    public LovelyAdsDialog setNegativeButtonColorRes(@ColorRes int colorRes) {
        return setNegativeButtonColor(color(colorRes));
    }

    public LovelyAdsDialog setNeutralButtonColorRes(@ColorRes int colorRes) {
        return setNeutralButtonColor(color(colorRes));
    }

    @Override
    protected int getLayout() {
        return ButtonLayout.HORIZONTAL.layoutRes;
    }

    public enum ButtonLayout {
        HORIZONTAL(R.layout.dialog_ads);

        final @LayoutRes int layoutRes;
        ButtonLayout(@LayoutRes int layoutRes) {
            this.layoutRes = layoutRes;
        }
    }
}
