package com.jobs.assignment.presentation.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jobs.assignment.R
import com.jobs.assignment.domain.model.Job
import com.jobs.assignment.util.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi

const val DEFAULT_IMAGE_VIEW = R.drawable.empty_image

@ExperimentalCoroutinesApi
@Composable
fun CardView(
    job: Job,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
                .padding(
                        bottom = 8.dp,
                        top = 8.dp,
                )
                .fillMaxWidth()
                .clickable(onClick = onClick),
        elevation = 10.dp,
    ) {

        Column {
            job.images!![0].let { url ->
                val image = loadPicture(url = url, defaultImage = DEFAULT_IMAGE_VIEW).value
                image?.let {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            bitmap = image.asImageBitmap(),
                            modifier = Modifier
                                    .fillMaxWidth()
                                    .preferredHeight(225.dp)
                                    .padding(8.dp),
                            contentScale = ContentScale.Crop,
                        )
                        val cost = job.cost.toString()
                        Button(
                            onClick = {}, modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(bottom = 8.dp, end = 8.dp),
                            enabled = false,
                            shape = RoundedCornerShape(topLeft = 30.dp, topRight = 0.dp, bottomLeft = 0.dp, bottomRight = 0.dp ),
                            colors = ButtonDefaults.textButtonColors(
                                backgroundColor = Color.White,
                            )
                        ) {
                            Text(
                                text = cost,
                                color = Color.Blue,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
            job.category.let { category ->
                Row(
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                ) {
                    Text(
                        text = category!!,
                        modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                        color = Color.Blue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row(
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp)
                ) {
                    val service = job.service.toString()
                    Text(
                            text = service,
                            modifier = Modifier
                                    .fillMaxWidth(0.85f)
                                    .wrapContentWidth(Alignment.Start),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.darkGray)
                    )
                }

                Row(
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp, start = 10.dp, end = 10.dp)
                ) {
                    val availability = job.availability.toString()
                    Text(
                        text = availability,
                        modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}