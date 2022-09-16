package com.example.artspace

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(){
    var currentIndex by remember { mutableStateOf(1) }
    val onPrevious = {
        currentIndex = if(currentIndex == 1) 6 else --currentIndex
    }
    val onNext = {
        currentIndex = if(currentIndex == 6) 1 else ++currentIndex
    }
    when(currentIndex){
        1 -> ArtWorkTextAndImage(
            drawble = R.drawable.cardinal,
            contentDescription = R.string.cardinal_content_description,
            title = R.string.cardinal_title,
            artist = R.string.cardinal_artist,
            year = R.string.cardinal_year,
            onPreviousClick = onPrevious,
            onNextClick = onNext
        )
        2 -> ArtWorkTextAndImage(
            drawble = R.drawable.forest,
            contentDescription = R.string.mobile_view_forest_content_description,
            title = R.string.mobile_view_forest_title,
            artist = R.string.mobile_view_forest_artist,
            year = R.string.mobile_view_forest_year,
            onPreviousClick = onPrevious,
            onNextClick = onNext
        )
        3 -> ArtWorkTextAndImage(
            drawble = R.drawable.lake,
            contentDescription = R.string.lake_content_description,
            title = R.string.lake_title,
            artist = R.string.lake_artist,
            year = R.string.lake_year,
            onPreviousClick = onPrevious,
            onNextClick = onNext
        )
        4 -> ArtWorkTextAndImage(
            drawble = R.drawable.tree_natural,
            contentDescription = R.string.tree_natural_content_description,
            title = R.string.tree_natural_title,
            artist = R.string.tree_natural_artist,
            year = R.string.tree_natural_year,
            onPreviousClick = onPrevious,
            onNextClick = onNext
        )
        5 -> ArtWorkTextAndImage(
            drawble = R.drawable.squirrel,
            contentDescription = R.string.squirrel_content_description,
            title = R.string.squirrel_title,
            artist = R.string.squirrel_artist,
            year = R.string.squirrel_year,
            onPreviousClick = onPrevious,
            onNextClick = onNext
        )
        6 -> ArtWorkTextAndImage(
            drawble = R.drawable.tree_view,
            contentDescription = R.string.tree_view_content_description,
            title = R.string.tree_view_title,
            artist = R.string.tree_view_artist,
            year = R.string.tree_view_year,
            onPreviousClick = onPrevious,
            onNextClick = onNext
        )
    }

}
@Composable
fun ArtWorkTextAndImage(drawble : Int, contentDescription: Int, title: Int, artist: Int, year: Int,onPreviousClick: () -> Unit, onNextClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxHeight()
            .weight(3f)
        ) {

            Image(painter = painterResource(id = drawble),
                contentDescription = stringResource(id = contentDescription),

                modifier = Modifier
                    .border(width = 3.dp, color = Color.Gray, shape = RectangleShape)
                    .padding(35.dp).align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        ArtworkDescription(title,artist,year)
        Spacer(modifier = Modifier.height(24.dp))
        ActionButtons(onPrevious = onPreviousClick,onNext = onNextClick)
    }
}
@Composable
fun ArtworkDescription(title: Int, artist: Int, year: Int){
    Column(modifier = Modifier
        .shadow(elevation = 3.dp, shape = RectangleShape)
    ) {
        Text(text = stringResource(id = title),
            fontSize = 24.sp,
            color = Color(104,104,104),
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp)
        )
        Row(modifier = Modifier.padding(bottom = 20.dp,start = 20.dp, end = 20.dp)){
            Text(text = stringResource(id = artist),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(text = "(" + stringResource(id = year) + ")" ,
                fontSize = 16.sp,
                color = Color(125,125,125)
            )
        }

    }
}
@Composable
fun ActionButtons(onPrevious: () -> Unit, onNext: () -> Unit){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = onPrevious,
            modifier = Modifier.width(150.dp)
        ) {
            Text(text = stringResource(id = R.string.previous))
        }
        Button(
            onClick = onNext,
            modifier = Modifier.width(150.dp)
        ) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}