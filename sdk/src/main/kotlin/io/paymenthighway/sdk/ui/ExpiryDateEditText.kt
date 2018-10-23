package io.paymenthighway.sdk.ui

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.View
import io.paymenthighway.sdk.R
import io.paymenthighway.sdk.model.ExpiryDate

/**
 * Specialized text field for collecting expiration date.
 */
class ExpiryDateEditText @JvmOverloads constructor(context: Context, attr: AttributeSet? = null): EditText(context, attr) {

    /**
     * The expiry date formatter need to know if the last key has been a <del>
     */
    private var lastKeyDel = false

    /**
     * Initialize the EditText with specific formatter, validator and hint and error texts
     *
     * @see ExpiryDate.format
     * @see ExpiryDate.isValid
     */
    init {
        hintText = resources.getString(R.string.expiry_date_hint)
        errorText = resources.getString(R.string.error_expiry_date)
        format = { ExpiryDate.format(it, lastKeyDel) }
        validate = { ExpiryDate.isValid(it) }
        setOnKeyListener(View.OnKeyListener { _, keyCode, _ ->
            lastKeyDel = if (keyCode == KeyEvent.KEYCODE_DEL) true else false;
            false
        })
    }
}