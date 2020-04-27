package xyz.belvi.phrase

import xyz.belvi.phrase.helpers.PhraseSpannableStringBuilder
import xyz.belvi.phrase.options.DetectedLanguage
import xyz.belvi.phrase.options.PhraseOptions
import xyz.belvi.phrase.translateMedium.TranslationMedium
import xyz.belvi.phrase.translateMedium.medium.GoogleTranslate

class Phrase internal constructor() {

    internal val phraseImpl = PhraseImpl()

    companion object {
        private val phrase = Phrase()
        fun with(translationMedium: TranslationMedium): PhraseBuilderUseCase {
            return PhraseImpl.Companion.Builder(translationMedium, phrase)
        }

        fun instance(): Phrase {
            return phrase
        }
    }

    fun translate(text: String, options: PhraseOptions? = null): String {
        return phraseImpl.translate(text, options)
    }

    fun detectLanguage(text: String, options: PhraseOptions? = null): DetectedLanguage {
        return phraseImpl.detect(text, options)
    }
}