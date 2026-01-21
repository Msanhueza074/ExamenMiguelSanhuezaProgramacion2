package cl.msanhueza.examenmiguelsanhuezap2.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcl/msanhueza/examenmiguelsanhuezap2/viewmodel/MedicionViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcl/msanhueza/examenmiguelsanhuezap2/repository/MedicionRepository;", "(Lcl/msanhueza/examenmiguelsanhuezap2/repository/MedicionRepository;)V", "mediciones", "Lkotlinx/coroutines/flow/Flow;", "", "Lcl/msanhueza/examenmiguelsanhuezap2/data/entity/Medicion;", "getMediciones", "()Lkotlinx/coroutines/flow/Flow;", "agregar", "", "tipo", "", "valor", "", "fecha", "app_debug"})
public final class MedicionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final cl.msanhueza.examenmiguelsanhuezap2.repository.MedicionRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion>> mediciones = null;
    
    public MedicionViewModel(@org.jetbrains.annotations.NotNull()
    cl.msanhueza.examenmiguelsanhuezap2.repository.MedicionRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion>> getMediciones() {
        return null;
    }
    
    public final void agregar(@org.jetbrains.annotations.NotNull()
    java.lang.String tipo, int valor, @org.jetbrains.annotations.NotNull()
    java.lang.String fecha) {
    }
}