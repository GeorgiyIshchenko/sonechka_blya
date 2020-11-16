package ru.dublgis.dgismobile.mapsdk.directions

import android.util.JsonWriter
import ru.dublgis.dgismobile.mapsdk.IPlatformSerializable
import ru.dublgis.dgismobile.mapsdk.LonLat


/**
 * Pedestrian route options
 */
open class PedestrianRouteOptions(
    /**
     * Array of geographical points [longitude, latitude].
     * You can set up to 10 points.
     */
    var points: Collection<LonLat>
) : IPlatformSerializable {

    override fun toString(): String {
        val arg = points.joinToString(
            separator = ",",
            prefix = "[",
            postfix = ",]",
            transform = {
                "[${it.lon}, ${it.lat}]"
            }
        )
        return "{ points: $arg }"
    }

    override fun dump(writer: JsonWriter) {
        writer.apply {
            beginObject()
            name("points")
                beginArray()
                    points.forEach {
                        it.dump(writer)
                    }
                endArray()
            endObject()
        }
    }
}
