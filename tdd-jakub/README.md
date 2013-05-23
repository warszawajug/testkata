Use case:
# customer wysyła dane do płatności (id billera, msisdn customera, id produktu)
# system sprawdza, w zewnętrznym systemie billera, czy płatność jest możliwa dla danego msisdn'a
# system dolicza opłaty
# system przekazuje polecenie przelewu do core'owego systemu bankowego
# system zapisuje płatność
# system powiadamia zewnętrzny system billera, o udanej płatności
# system zwraca customerowi potwierdzenie udanej płatności

W przypadku niepowodzenia, system musi zapisać próbę płatności.