import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import java.io.IOException
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager
import java.security.cert.X509Certificate
import java.security.SecureRandom
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody


private fun certificationVerify(): OkHttpClient {
    // Certification Verify
    // Criar o SSLContext que desativa a validação de certificados
    val sslContext = SSLContext.getInstance("TLS")
    val trustAllCertificates = object : X509TrustManager {
        override fun getAcceptedIssuers(): Array<X509Certificate>? {
            return arrayOf()  // Retorna uma lista vazia de emissores aceitos
        }

        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
    }

    sslContext.init(null, arrayOf(trustAllCertificates), SecureRandom())
    val sslSocketFactory = sslContext.socketFactory

    // Criar o OkHttpClient com o SSLContext modificado
    val client = OkHttpClient.Builder()
        .followRedirects(false)
        .sslSocketFactory(sslSocketFactory, trustAllCertificates) // Usar o SSLFactory modificado
        .hostnameVerifier { _, _ -> true }  // Ignorar a verificação do hostname
        .build()
    return client
}

fun listarUsers(): List<Map<String, Any>> {

    var data: List<Map<String, Any>> = emptyList()

    val client = certificationVerify()

    val request = Request.Builder()
        .url("https://192.168.50.76/api.php?action=listarUsers")
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) throw IOException("Erro na requisição: ${response.code}")

        val jsonResponse = response.body?.string()
        println("Resposta da API: $jsonResponse")

        if (jsonResponse != null) {
            try {
                val apiResponseType = object : TypeToken<Map<String, Any>>() {}.type
                val apiResponse: Map<String, Any> = Gson().fromJson(jsonResponse, apiResponseType)

                if (apiResponse["status"] == "success" && apiResponse["data"] is List<*>) {
                    data = apiResponse["data"] as List<Map<String, Any>>
                } else {
                    println("Falha na API: ${apiResponse["status"]}")
                }
            } catch (e: JsonSyntaxException) {
                println("Erro ao parsear o JSON: ${e.message}")
            }
        }
    }

    return data
}

fun login(email: String, pass: String): Map<String, Any> {

    val json = """
        {
            "email": "$email",
            "pass": "$pass"
        }
    """.trimIndent()
    val mediaType = "application/json; charset=utf-8".toMediaType()
    val requestBody = json.toRequestBody(mediaType)

    var data: Map<String, Any> = emptyMap()

    val client = certificationVerify()

    val request = Request.Builder()
        .url("https://192.168.50.76/api.php?action=login")
        .post(requestBody)
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) throw IOException("Erro na requisição: ${response.code}")

        val jsonResponse = response.body?.string()
        println("Resposta da API: $jsonResponse")

        if (jsonResponse != null) {
            try {
                val apiResponseType = object : TypeToken<Map<String, Any>>() {}.type
                val apiResponse: Map<String, Any> = Gson().fromJson(jsonResponse, apiResponseType)

                if (apiResponse["status"] == "success" && apiResponse["data"] is Map<*, *>) {
                    data = apiResponse["data"] as Map<String, Any>
                } else {
                    println("Falha na API: ${apiResponse["status"]}")
                }
            } catch (e: JsonSyntaxException) {
                println("Erro ao parsear o JSON: ${e.message}")
            }
        }
    }

    return data
}
