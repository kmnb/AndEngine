package org.andengine.opengl.font;

import android.util.SparseIntArray;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 10:30:22 - 03.04.2010
 */
public class Letter {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public final char mCharacter;
	public final int mTextureX;
	public final int mTextureY;
	public final int mWidth;
	public final int mHeight;
	public final float mOffsetX;
	public final float mOffsetY;
	public final float mAdvance;
	public final float mU;
	public final float mV;
	public final float mU2;
	public final float mV2;
	private SparseIntArray mKernings;

	// ===========================================================
	// Constructors
	// ===========================================================

	Letter(final char pCharacter, final int pTextureX, final int pTextureY, final int pWidth, final int pHeight, final float pOffsetX, final float pOffsetY, final float pAdvance, final float pU, final float pV, final float pU2, final float pV2) {
		this.mCharacter = pCharacter;
		this.mWidth = pWidth;
		this.mHeight = pHeight;
		this.mTextureX = pTextureX;
		this.mTextureY = pTextureY;
		this.mOffsetX = pOffsetX;
		this.mOffsetY = pOffsetY;
		this.mAdvance = pAdvance;
		this.mU = pU;
		this.mV = pV;
		this.mU2 = pU2;
		this.mV2 = pV2;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public int getKerning(final int pCharacter) {
		if(this.mKernings == null) {
			return 0;
		}
		return mKernings.get(pCharacter, 0);
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.mCharacter;
		return result;
	}

	@Override
	public boolean equals(final Object pObject) {
		if(this == pObject) {
			return true;
		}
		if(pObject == null) {
			return false;
		}
		if(this.getClass() != pObject.getClass()) {
			return false;
		}
		final Letter other = (Letter) pObject;
		if(this.mCharacter != other.mCharacter) {
			return false;
		}
		return true;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	void addKerning(final int pCharacter, final int pKerning) {
		if(this.mKernings == null) {
			this.mKernings = new SparseIntArray();
		}
		this.mKernings.put(pCharacter, pKerning);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}