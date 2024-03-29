/*
 * Copyright 2016 Scalified <http://www.scalified.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.modernpos.tps_coffee.scalified.fab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.Animation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Deprecated since version <b>1.0.2</b>. Use {@link ActionButton}
 * class instead.
 * The reason is the rename of base class name from <b>FloatingActionButton</b> to
 * <b>ActionButton</b> and some of the methods, which are present in this class. 
 * <p>
 * Will be removed in version 2.0.0. Please use {@link ActionButton} and
 * methods declared there instead
 *
 * @author Vladislav
 * @version 1.0.1
 * @since 1.0.0
 */
@Deprecated
public class FloatingActionButton extends ActionButton {

	/**
	 * Logger
	 */
	@SuppressWarnings("deprecation")
	private static final Logger LOGGER = LoggerFactory.getLogger(FloatingActionButton.class);
	
	@Deprecated
	public FloatingActionButton(Context context) {
		super(context);
	}

	@Deprecated
	public FloatingActionButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initActionButton(context, attrs, 0, 0);
	}

	@Deprecated
	public FloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initActionButton(context, attrs, defStyleAttr, 0);
	}

	@Deprecated
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public FloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initActionButton(context, attrs, defStyleAttr, defStyleRes);
	}

	/**
	 * Returns an animation, which is used while showing <b>Floating Action Button</b>
	 * @deprecated since version <b>1.0.2</b>. Please use {@link #getShowAnimation()} instead
	 *
	 * @return animation, which is used while showing <b>Floating Action Button</b>
	 */
	@Deprecated
	public Animation getAnimationOnShow() {
		return getShowAnimation();
	}

	/**
	 * Sets the animation, which is used while showing <b>Floating Action Button</b>
	 * @deprecated since version <b>1.0.2</b>. Please use
	 * {@link #setShowAnimation(Animation)} instead
	 *
	 * @param animation animation, which is to be used while showing
	 *                  <b>Floating Action Button</b>
	 */
	@Deprecated
	public void setAnimationOnShow(Animation animation) {
		setShowAnimation(animation);
	}

	/**
	 * Sets one of the {@link Animations} as animation, which is used while showing
	 * <b>Floating Action Button</b>
	 * @deprecated since version <b>1.0.2</b>. Please use
	 * {@link #setShowAnimation(ActionButton.Animations)} instead
	 *
	 * @param animation one of the {@link Animations}, which is to be used while
	 *                  showing <b>Floating Action Button</b>
	 */
	@Deprecated
	public void setAnimationOnShow(Animations animation) {
		setShowAnimation(animation);
	}

	/**
	 * Returns an animation, which is used while hiding <b>Floating Action Button</b>
	 * @deprecated since version <b>1.0.2</b>. Please use {@link #getHideAnimation()}
	 * instead
	 *
	 * @return animation, which is used while hiding <b>Floating Action Button</b>
	 */
	@Deprecated
	public Animation getAnimationOnHide() {
		return getHideAnimation();
	}

	/**
	 * Sets the animation, which is used while hiding <b>Floating Action Button</b>
	 * @deprecated since version <b>1.0.2</b>. Please use
	 * {@link #setHideAnimation(Animation)} instead
	 *
	 * @param animation animation, which is to be used while hiding
	 *                  <b>Floating Action Button</b>
	 */
	@Deprecated
	public void setAnimationOnHide(Animation animation) {
		setHideAnimation(animation);
	}

	/**
	 * Sets one of the {@link Animations} as animation, which is used while hiding
	 * <b>Floating Action Button</b>
	 * @deprecated since version <b>1.0.2</b>. Please use
	 * {@link #setHideAnimation(ActionButton.Animations)} )} instead
	 *
	 * @param animation one of the {@link Animations}, which is to be used while
	 *                  hiding <b>Floating Action Button</b>
	 */
	@Deprecated
	public void setAnimationOnHide(Animations animation) {
		setHideAnimation(animation);
	}

	@SuppressWarnings("deprecation")
	private void initActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ActionButton,
				defStyleAttr, defStyleRes);
		try {
			initType(attributes);
			initShowAnimation(attributes);
			initHideAnimation(attributes);
		} catch (Exception e) {
			LOGGER.error("Failed to read the attribute", e);
		} finally {
			attributes.recycle();
		}
		LOGGER.trace("Initialized Floating Action Button");
	}

	private void initType(TypedArray attrs) {
		if (attrs.hasValue(R.styleable.ActionButton_type)) {
			final int id = attrs.getInteger(R.styleable.ActionButton_type, 0);
			setType(Type.forId(id));
			LOGGER.trace("Initialized type: {}", getType());
		}
	}

	/**
	 * Initializes the animation, which is used while showing 
	 * <b>Action Button</b>
	 * @deprecated since 1.0.2 and will be removed in version 2.0.0.
	 * Use <b>show_animation</b> and <b>hide_animation</b> in XML instead 
	 *
	 * @param attrs attributes of the XML tag that is inflating the view
	 */
	@Deprecated
	private void initShowAnimation(TypedArray attrs) {
		if (attrs.hasValue(R.styleable.ActionButton_animation_onShow)) {
			final int animResId = attrs.getResourceId(R.styleable.ActionButton_animation_onShow,
					Animations.NONE.animResId);
			setShowAnimation(Animations.load(getContext(), animResId));
		}
	}

	/**
	 * Initializes the animation, which is used while hiding or dismissing
	 * <b>Action Button</b>
	 * @deprecated since 1.0.2 and will be removed in version 2.0.0
	 * Use <b>show_animation</b> and <b>hide_animation</b> in XML instead 
	 *
	 * @param attrs attributes of the XML tag that is inflating the view
	 */
	@Deprecated
	private void initHideAnimation(TypedArray attrs) {
		if (attrs.hasValue(R.styleable.ActionButton_animation_onHide)) {
			final int animResId = attrs.getResourceId(R.styleable.ActionButton_animation_onHide,
					Animations.NONE.animResId);
			setHideAnimation(Animations.load(getContext(), animResId));
		}
	}
	
}
