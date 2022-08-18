package dev.arthurdamous.instagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.arthurdamous.instagram.ui.theme.InstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val listOfPostUsers = listOf(
                        UserPost(
                            id = 1,
                            username = "arthurdamous",
                            postMessage = "dummy text dummy text",
                            postPhoto = R.drawable.foto_perfil,
                            profilePhoto = R.drawable.foto_perfil
                        ),
                        UserPost(
                            id = 1,
                            username = "silviosantos",
                            postMessage = "dummy text dummy text",
                            postPhoto = R.drawable.post1,
                            profilePhoto = R.drawable.photo2
                        ),
                        UserPost(
                            id = 1,
                            username = "ratinho",
                            postMessage = "dummy text dummy text",
                            postPhoto = R.drawable.post2,
                            profilePhoto = R.drawable.photo3
                        ),
                        UserPost(
                            id = 1,
                            username = "celsoportiolli",
                            postMessage = "dummy text dummy text",
                            postPhoto = R.drawable.post3,
                            profilePhoto = R.drawable.photo4
                        )

                    )

                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp)
                            ) {
                                Text(
                                    text = "Instagram",
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Black,
                                    fontFamily = FontFamily.Cursive,
                                    maxLines = 1,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.weight(0.7f)
                                )
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Favorite",
                                    modifier = Modifier
                                        .weight(0.1f)

                                )
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "Comments",
                                    modifier = Modifier
                                        .weight(0.1f)
                                )
                                Icon(
                                    imageVector = Icons.Default.Send,
                                    contentDescription = "Share",
                                    modifier = Modifier
                                        .weight(0.1f)
                                )

                            }
                            LazyColumn() {
                                items(listOfPostUsers.size) { i ->
                                    InstagramPost(userPost = listOfPostUsers[i])
                                    if(i > 0){
                                        Spacer(modifier = Modifier.height(15.dp))
                                    }
                                }
                            }
                        }

                    }

                }
            }
        }
    }
}


@Composable
fun InstagramPost(
    userPost: UserPost
) {

    Box(modifier = Modifier.fillMaxWidth()) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Box(
                    modifier = Modifier.weight(0.1f)
                ) {
                    Image(
                        painter = painterResource(id = userPost.profilePhoto!!),
                        contentDescription = "imagePhotoProfile",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = Color.Blue,
                                shape = RoundedCornerShape(100.dp)
                            )
                            .clip(RoundedCornerShape(100.dp))
                            .size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.weight(0.8f)
                ) {
                    Text(
                        text = userPost.username!!,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Belém",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier.weight(0.1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More"
                    )
                }

            }
            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {

                Image(
                    painter = painterResource(id = userPost.postPhoto!!),
                    contentDescription = "postImage",
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.Center
                )

            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .weight(0.1f)

                )
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Comments",
                    modifier = Modifier
                        .weight(0.1f)
                )
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Share",
                    modifier = Modifier
                        .weight(0.1f)
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = CenterVertically,
                    modifier = Modifier
                        .weight(0.7f)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = "favorite",
                        modifier = Modifier
                    )
                }

            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = userPost.profilePhoto!!),
                        contentDescription = "imagePhotoProfile",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(100.dp)
                            )
                            .clip(RoundedCornerShape(100.dp))
                            .size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Curtido por",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "joaosilva",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "e",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "outras 90 pessoas",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )


            }

            Spacer(modifier = Modifier.height(6.dp))

            Column(
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = userPost.username!!,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. ",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp)
            ) {
                Text(
                    text = "Ver todos os comentários",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = userPost.profilePhoto!!),
                        contentDescription = "imagePhotoProfile",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(100.dp))
                            .size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Adicione um comentário...",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Text(
                    text = "Há 13 horas",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "-",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Ver tradução",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
            }
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    InstagramTheme {
        InstagramPost(
            userPost = UserPost()
        )
    }
}