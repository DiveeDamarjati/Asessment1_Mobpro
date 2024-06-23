package org.d3if0106.miniproject.screen

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.d3if0106.miniproject.R
import org.d3if0106.miniproject.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.judul_kategori) )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background
                ),
                actions = {
                    IconButton(onClick = {navController.navigate(Screen.aboutUs.route)}) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = stringResource(id = R.string.tentang_aplikasi),
                            tint = MaterialTheme.colorScheme.background
                        )
                    }
                }
            )
        }
    ){
        paddingValues -> ScreenContent(Modifier.padding(paddingValues))
    }
}

@Composable
fun ScreenContent(modifier: Modifier){
    var tinggi by rememberSaveable { mutableStateOf("") }
    var tinggiError by rememberSaveable { mutableStateOf(false) }
    var umur by rememberSaveable { mutableStateOf("") }
    var umurError by rememberSaveable { mutableStateOf(false) }
    var radioOptions = listOf(
        stringResource(id = R.string.pria),
        stringResource(id = R.string.wanita)
    )
    var gender by remember { mutableStateOf(radioOptions[0]) }

    var kategori by remember { mutableStateOf(0) }

    var context = LocalContext.current

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.intro),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = umur,
            onValueChange = { umur = it },
            isError = umurError,
            label = { Text(text = stringResource(id = R.string.umur)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = tinggi,
            onValueChange = { tinggi = it },
            isError = tinggiError,
            label = { Text(text = stringResource(id = R.string.tinggibadan)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ) {
            radioOptions.forEach{ text -> GenderOption(
                label = text,
                isSelected = gender == text,
                modifier = Modifier
                    .selectable(
                        selected = gender == text,
                        onClick = { gender = text },
                        role = Role.RadioButton
                    )
                    .weight(1f)
                    .padding(15.dp)
            )
            }
        }
        Button(
            onClick = {
                tinggiError = (tinggi == "" || tinggi == "0")
                umurError = (umur == "" || umur == "0")
                if (tinggiError || umurError) return@Button

                kategori = getStatusTinggiBadan(tinggi.toFloat(), gender == radioOptions[0], umur.toInt())
            },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        ) {
            Text(text = stringResource(R.string.masukkan))
        }

        if (kategori != 0){
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
                thickness = 1.dp
            )
            Text(
                text = stringResource(kategori).uppercase(),
                style = MaterialTheme.typography.headlineLarge
            )
            Button(onClick = {
                shareData(
                    context = context,
                    message = context.getString(R.string.share, context.getString(kategori  ))
                )
            }
            ) {
                Text(text = stringResource(id = R.string.send))
            }
            Text(text = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")
        }
    }
}

private fun getStatusTinggiBadan(tinggi: Float, isMale: Boolean, umur: Int): Int {
    val kategori: String = when {
        umur >= 10 && umur <= 12 && isMale -> {
            when {
                tinggi < 145 -> "pendek"
                tinggi >= 145 && tinggi < 163 -> "normal"
                else -> "tinggi"
            }
        }
        umur >= 10 && umur <= 12 && !isMale -> {
            when {
                tinggi < 143 -> "pendek"
                tinggi >= 143 && tinggi < 160 -> "normal"
                else -> "tinggi"
            }
        }
        umur >= 13 && umur <= 15 && isMale -> {
            when {
                tinggi < 148 -> "pendek"
                tinggi >= 148 && tinggi < 168 -> "normal"
                else -> "tini"
            }
        }
        umur >= 13 && umur <= 15 && !isMale -> {
            when {
                tinggi < 150 -> "pendek"
                tinggi >= 150 && tinggi < 165 -> "normal"
                else -> "tinggi"
            }
        }
        umur >= 16 && umur <= 18 && isMale -> {
            when {
                tinggi < 168 -> "pendek"
                tinggi >= 168 && tinggi < 170 -> "normal"
                else -> "tinggi"
            }
        }
        umur >= 16 && umur <= 18 && !isMale -> {
            when {
                tinggi < 159 -> "pendek"
                tinggi >= 159 && tinggi <= 160-> "normal"
                else -> "tinggi"
            }
        }
        umur >= 19 && umur <= 29 && isMale -> {
            when {
                tinggi < 168 -> "pendek"
                tinggi >= 168 && tinggi < 170 -> "normal"
                else -> "tinggi"
            }
        }
        umur >= 19 && umur <= 29 && !isMale -> {
            when {
                tinggi < 159 -> "pendek"
                tinggi >= 159 && tinggi <= 160 -> "normal"
                else -> "tinggi"
            }
        }


        else -> "undefined" // Menambahkan penanganan jika tidak memenuhi kondisi umur atau jenis kelamin
    }

    // Map kategori menjadi nilai string yang sesuai
    return when (kategori) {
        "pendek" -> R.string.pendek
        "normal" -> R.string.normal
        "tinggi" -> R.string.tinggi
        else -> R.string.badag
    }
}

private fun shareData(context: Context, message: String){
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null){
        context.startActivity(shareIntent)
    }
}



@Composable
fun GenderOption(label: String, isSelected: Boolean, modifier: Modifier) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

