package io.paymenthighway.sdk.ui

import android.content.Context
import android.graphics.Rect
import android.text.InputFilter
import android.util.AttributeSet
import io.paymenthighway.sdk.CardBrand
import io.paymenthighway.sdk.R
import io.paymenthighway.sdk.model.CardData

/**
 * Specialized text field for collecting credit number.
 */
class CardNumberEditText @JvmOverloads constructor(context: Context, attr: AttributeSet? = null): EditText(context, attr) {

    /**
     * Initialize the EditText with specific formatter, validator and hint and error texts
     *
     * @see CardData.formatCardNumber
     * @see CardData.isCardNumberValid
     */
    init {
        hintText = resources.getString(R.string.card_number_hint)
        errorText = resources.getString(R.string.error_card_number)
        format = { CardData.formatCardNumber(it) }
        validate = { CardData.isCardNumberValid(it) }
    }

}