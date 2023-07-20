package com.example.romitsbmicalculator;



import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.editTextWeight);
        heightEditText = findViewById(R.id.editTextHeight);
        resultTextView = findViewById(R.id.textViewResult);
        calculateButton = findViewById(R.id.buttonCalculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // Convert height from cm to m

            float bmi = weight / (height * height);

            displayResult(bmi);
        }
    }

    private void displayResult(float bmi) {
        String result;

        if (bmi < 18.5) {
            result = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            result = "Normal Weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            result = "Overweight";
        } else {
            result = "Obese";
        }

        resultTextView.setText("BMI: " + String.format("%.2f", bmi) + "\n" + result);
    }
}
