package cl.msanhueza.examenmiguelsanhuezap2.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcl/msanhueza/examenmiguelsanhuezap2/data/dao/MedicionDao;", "", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcl/msanhueza/examenmiguelsanhuezap2/data/entity/Medicion;", "insert", "", "medicion", "(Lcl/msanhueza/examenmiguelsanhuezap2/data/entity/Medicion;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface MedicionDao {
    
    @androidx.room.Query(value = "SELECT * FROM mediciones ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion>> getAll();
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    cl.msanhueza.examenmiguelsanhuezap2.data.entity.Medicion medicion, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}