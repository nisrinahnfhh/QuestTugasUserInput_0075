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