package com.mohamedrejeb.calf.permissions

import com.mohamedrejeb.calf.permissions.helper.AVCapturePermissionHelper
import com.mohamedrejeb.calf.permissions.helper.BluetoothPermissionHelper
import com.mohamedrejeb.calf.permissions.helper.GalleryPermissionHelper
import com.mohamedrejeb.calf.permissions.helper.GrantedPermissionHelper
import com.mohamedrejeb.calf.permissions.helper.LocalNotificationPermissionHelper
import com.mohamedrejeb.calf.permissions.helper.LocationPermissionHelper
import com.mohamedrejeb.calf.permissions.helper.PermissionHelper
import com.mohamedrejeb.calf.permissions.helper.RemoteNotificationPermissionHelper
import platform.AVFoundation.AVMediaTypeAudio
import platform.AVFoundation.AVMediaTypeVideo

internal fun Permission.getPermissionDelegate(): PermissionHelper {
    return when (this) {
        Permission.Camera -> AVCapturePermissionHelper(AVMediaTypeVideo)
        Permission.Gallery -> GalleryPermissionHelper()
        Permission.ReadStorage, Permission.WriteStorage, Permission.Call -> GrantedPermissionHelper()
        Permission.FineLocation, Permission.CoarseLocation -> LocationPermissionHelper()
        Permission.Notification -> LocalNotificationPermissionHelper()
        Permission.RemoteNotification -> RemoteNotificationPermissionHelper()
        Permission.RecordAudio -> AVCapturePermissionHelper(AVMediaTypeAudio)
        Permission.BluetoothLe, Permission.BluetoothScan,
        Permission.BluetoothConnect, Permission.BluetoothAdvertise,
        -> BluetoothPermissionHelper()

    }
}
