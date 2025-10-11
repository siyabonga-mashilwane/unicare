package com.example.unicare.UIComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import com.example.unicare.UIComponents.ButtonFactory.CreateButton
import org.jetbrains.compose.ui.tooling.preview.Preview


import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.ButtonDefaults
import com.example.unicare.UIComponents.ButtonFactory.BackButton
import androidx.compose.ui.graphics.Color


import com.example.unicare.Utils.FontSize
import com.example.unicare.Utils.FontSizeType.Small
import com.example.unicare.Utils.FontSizeType.Medium
import com.example.unicare.Utils.FontSizeType.Large


enum class ButtonType {
    SMALL,
    MEDIUM,
    LARGE
}


object ButtonFactory {

    @Composable
    fun CreateButton(
        text: String,
        type: ButtonType,
//        color: MaterialTheme,
        rounded: Boolean = true,
        onClickAction: () -> Unit
    ) {
        val height = when (type) {
            ButtonType.SMALL -> 36.dp
            ButtonType.MEDIUM -> 48.dp
            ButtonType.LARGE -> 60.dp
        }

        val fontSize = when (type) {
            ButtonType.SMALL -> FontSize.get(Small)
            ButtonType.MEDIUM -> FontSize.get(Medium)
            ButtonType.LARGE -> FontSize.get(Large)
        }

        val width = when (type){
            ButtonType.SMALL -> 92.dp
            ButtonType.MEDIUM -> 130.dp
            ButtonType.LARGE -> 150.dp

        }

        val round = if(rounded) 100.dp else 7.dp
        Button(
            onClick = onClickAction,
            modifier = Modifier.wrapContentHeight().width(width),
            contentPadding = PaddingValues(
                horizontal = 0.dp,
                vertical = 0.dp
            ),
            shape = RoundedCornerShape(round),
            colors = ButtonDefaults.buttonColors(
//                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onBackground
            )
        ) {
            Text(text = text, fontSize = fontSize)
        }
    }
    @Composable
    fun BackButton(text: String, onClick: () -> Unit){

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.wrapContentSize(),
            contentPadding = PaddingValues(0.dp) // remove internal padding
        ) {
            Icon(
                imageVector = Icons.Default.ChevronLeft,
                contentDescription = "Back"
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text)
        }

    }
}
@Preview(showBackground = true)
@Composable

fun MyButtonPreview() {
    MaterialTheme() {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            CreateButton(text = "Small", type = ButtonType.SMALL, rounded = true, onClickAction = { println("Button rounded small") })
            CreateButton(text = "Medium", type = ButtonType.MEDIUM, rounded = true, onClickAction = { println("Button rounded Medium") })
            CreateButton(text = "Large", type = ButtonType.LARGE, rounded = true, onClickAction = { println("Button rounded Large") })
            CreateButton(text = "Small", type = ButtonType.SMALL, rounded = false, onClickAction = {})
            CreateButton(text = "Medium", type = ButtonType.MEDIUM, rounded = false, onClickAction = {})
            CreateButton(text = "Large", type = ButtonType.LARGE, rounded = false, onClickAction = {})
            BackButton(text = "Back", onClick = {})
        }
    }
}

