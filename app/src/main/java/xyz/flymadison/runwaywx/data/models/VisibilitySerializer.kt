package xyz.flymadison.runwaywx.data.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive

object VisibilitySerializer : KSerializer<Float?> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Visib", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Float? {
        val input = decoder as? JsonDecoder
            ?: throw Exception("Expected JsonDecoder")

        val element = input.decodeJsonElement()

        return when (element) {
            is JsonPrimitive -> {
                val content = element.content.replace("+", "")
                content.toFloatOrNull()
            }
            else -> null
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Float?) {
        if (value != null) {
            encoder.encodeString(value.toString())
        } else {
            encoder.encodeNull()
        }
    }
}