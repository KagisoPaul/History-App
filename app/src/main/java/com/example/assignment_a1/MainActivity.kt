import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_a1.R

class MainActivity : AppCompatActivity() {

    private lateinit var ageInput: EditText
    private lateinit var compareButton: Button
    private lateinit var resultText: TextView
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageInput = findViewById(R.id.age_input)
        compareButton = findViewById(R.id.compare_button)
        resultText = findViewById(R.id.result_text)
        clearButton = findViewById(R.id.clear_button)

        compareButton.setOnClickListener {
            compareAges()
        }

        clearButton.setOnClickListener {
            clearInputAndResult()
        }
    }

    private fun compareAges() {
        val ageString = ageInput.text.toString()

        if (ageString.isEmpty()) {
            resultText.text = getString(R.string.error_empty_age)
            return
        }

        val age = ageString.toIntOrNull()
        if (age == null) {
            resultText.text = getString(R.string.error_invalid_age_format)
            return
        }

        if (age !in 20..100) {
            resultText.text = getString(R.string.error_age_out_of_range)
            return
        }

        val historicalFigure = getHistoricalFigure(age)
        resultText.text = "${historicalFigure.name} passed away at the age of ${historicalFigure.age}."
    }

    private fun getHistoricalFigure(age: Int): HistoricalFigure {
        return HistoricalFigure("Nelson Mandela", 95)
        return HistoricalFigure("William Shakespeare", 52)
        return HistoricalFigure("William Shakespeare", 67)
        return HistoricalFigure("Leonardo Da Vinci", 76)
        return HistoricalFigure("Mahatma Ghandhi", 78)
        return HistoricalFigure("Isaac Newton", 84)
        return HistoricalFigure("Cleopatra", 39)
        return HistoricalFigure("Wolfgang Amadeus Mozart ", 35)
        return HistoricalFigure("Amelia Earhart", 39)
        return HistoricalFigure("arie Curie", 66)

    }

    private fun clearInputAndResult() {
        ageInput.text.clear()
        resultText.text = ""
    }
}

data class HistoricalFigure(val name: String, val age: Int)

fun String?.isEmpty(): Boolean {
    return this == null || this.isEmpty()
}

fun String?.toIntOrNull(): Int? {
    return try {
        this?.toIntOrNull()
    } catch (e: NumberFormatException) {
        null
    }
}
