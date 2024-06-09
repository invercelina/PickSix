package com.example.picksix

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(
    supabaseUrl = BuildConfig.supabaseUrl,
    supabaseKey = BuildConfig.supabaseKey
) {
    install(Postgrest)
    install(Auth)
}