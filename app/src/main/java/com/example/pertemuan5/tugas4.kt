package com.example.pertemuan5

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Act4() {

    var namaDepan by remember { mutableStateOf(value = "") }
    var namaBelakang by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var tglLahir by remember { mutableStateOf(value = "") }
    var experience by remember { mutableStateOf(value = "") }
    var expanded by remember { mutableStateOf(value = false) }

    var skillAndroid by remember { mutableStateOf(value = false) }
    var skillUiux by remember { mutableStateOf(value = false) }
    var skillWeb by remember { mutableStateOf(value = false) }

    var tampilDatePicker by remember { mutableStateOf(value = false) }
    val datePickerState = rememberDatePickerState()
    val formatTanggal = stringResource(id = R.string.format_tanggal)

    var tampilHasil by remember { mutableStateOf(value = false) }
    var hasilNamaDepan by remember { mutableStateOf(value = "") }
    var hasilNamaBelakang by remember { mutableStateOf(value = "") }
    var hasilTgl by remember { mutableStateOf(value = "") }
    var hasilExperience by remember { mutableStateOf(value = "") }
    var hasilEmail by remember { mutableStateOf(value = "") }
    var hasilSkill by remember { mutableStateOf(value = "") }

    val listExperience = stringArrayResource(id = R.array.experience_list)

    val teksAndroid = stringResource(id = R.string.skill_android)
    val teksUiux = stringResource(id = R.string.skill_uiux)
    val teksWeb = stringResource(id = R.string.skill_web)
    val pemisahSkill = stringResource(id = R.string.pemisah_skill)

    val formLengkap = namaDepan.isNotEmpty() &&
            namaBelakang.isNotEmpty() &&
            email.isNotEmpty() &&
            tglLahir.isNotEmpty() &&
            experience.isNotEmpty() &&
            (skillAndroid || skillUiux || skillWeb)

    val bentukField = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner))
    val bentukCard = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner))
    val bentukHasil = RoundedCornerShape(dimensionResource(id = R.dimen.hasil_corner))

    if (tampilDatePicker) {
        DatePickerDialog(
            onDismissRequest = { tampilDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val formatter = SimpleDateFormat(formatTanggal, Locale.getDefault())
                            formatter.timeZone = TimeZone.getTimeZone("UTC")
                            tglLahir = formatter.format(Date(millis))
                        }
                        tampilDatePicker = false
                    }
                ) {
                    Text(text = stringResource(id = R.string.btn_ok))
                }
            },
            dismissButton = {
                TextButton(onClick = { tampilDatePicker = false }) {
                    Text(text = stringResource(id = R.string.btn_batal))
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = stringResource(id = R.string.cd_background),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(dimensionResource(id = R.dimen.dot_padding)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dot_spacing))
            ) {
                Box(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.dot_size))
                        .background(colorResource(id = R.color.biru_dot), CircleShape)
                )
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.dot_size))
                            .background(colorResource(id = R.color.abu_dot), CircleShape)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = dimensionResource(id = R.dimen.card_margin_bottom))
                    .fillMaxWidth()
                    .shadow(
                        elevation = dimensionResource(id = R.dimen.card_elevation),
                        shape = bentukCard
                    )
                    .background(colorResource(id = R.color.putih), bentukCard)
                    .padding(
                        start = dimensionResource(id = R.dimen.card_padding_horizontal),
                        end = dimensionResource(id = R.dimen.card_padding_horizontal),
                        top = dimensionResource(id = R.dimen.card_padding_top),
                        bottom = dimensionResource(id = R.dimen.card_padding_bottom)
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.judul_form),
                        fontSize = dimensionResource(id = R.dimen.title_size).value.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.biru_judul)
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))
                    Text(
                        text = stringResource(id = R.string.subjudul_form),
                        fontSize = dimensionResource(id = R.dimen.subtitle_size).value.sp,
                        color = colorResource(id = R.color.abu_teks),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_large)))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacing_small))
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            singleLine = true,
                            shape = bentukField,
                            modifier = Modifier.weight(1f),
                            label = { Text(text = stringResource(id = R.string.nama_depan)) },
                            onValueChange = { namaDepan = it }
                        )
                        OutlinedTextField(
                            value = namaBelakang,
                            singleLine = true,
                            shape = bentukField,
                            modifier = Modifier.weight(1f),
                            label = { Text(text = stringResource(id = R.string.nama_belakang)) },
                            onValueChange = { namaBelakang = it }
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                    OutlinedTextField(
                        value = email,
                        singleLine = true,
                        shape = bentukField,
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(text = stringResource(id = R.string.email)) },
                        onValueChange = { email = it }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))




