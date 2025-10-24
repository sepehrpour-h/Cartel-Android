import com.sepehrpour.cartel.data.model.Role
import com.sepehrpour.cartel.data.model.Scenario
import com.sepehrpour.cartel.data.model.TeamType

object ScenarioRepository {

    private val scenarios = listOf(
        Scenario(
            id = "dark_arts",
            title = "هنرهای تاریک",
            description = "در این سناریو شهر درگیر نیروهای تاریک شده...",
            roles = listOf(
                Role("مافیا", "گروه مافیا که شب‌ها دست به حذف می‌زنند", TeamType.MAFIA),
                Role("بازپرس", "هر شب یکی از بازیکنان را بررسی می‌کند", TeamType.CITIZEN),
                Role("پزشک", "هر شب یک نفر را از حذف نجات می‌دهد", TeamType.CITIZEN),
                Role("دلقک", "«بی‌طرف» که قصد جلب توجه دارد", TeamType.NEUTRAL)
            )
        ),
        Scenario(
            id = "urban_madness",
            title = "شهر جنون",
            description = "ترکیبی از نقش‌های جدید برای هیجان بیشتر!",
            roles = listOf(
                Role("پدرخوانده", "رهبر مافیا با قدرت مقاومت در مقابل بازپرس", TeamType.MAFIA),
                Role("بازپرس", "قلب نبض شهر در کشف حقیقت", TeamType.CITIZEN),
                Role("اسنایپر", "توان حذف یک نفر در طول بازی", TeamType.CITIZEN),
                Role("خیانتکار", "نقش پنهان با اهداف شخصی", TeamType.NEUTRAL)
            )
        )
    )

    fun getScenarios(): List<Scenario> = scenarios

    fun getScenarioById(id: String): Scenario? =
        scenarios.firstOrNull { it.id == id }
}