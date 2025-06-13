package retanar.ttmolfar.util

import android.content.Context
import android.widget.Toast

fun Context.showComingSoonToast() {
    Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
}
